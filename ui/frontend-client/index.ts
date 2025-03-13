/**
 *
 * Part of Lines Monitor system
 * A TypeScript library to collect basic performance metrics
 * and send them to backend.
 */
export interface LinesMonitorClientConfig {
	baseUrl: string;
	projectId: string;
}

export class LinesMonitorClient {
	#baseUrl = '';
	#projectId = '';

	constructor(options: LinesMonitorClientConfig) {
		this.#baseUrl = options.baseUrl;
		this.#projectId = options.projectId;
	}

	init() {
		this.collectNavigationTiming();
		this.collectPaintTiming();
	}

	colectLoadTime() {
		const timing = performance.timing;
		const pageLoadTime = timing.loadEventEnd - timing.navigationStart;

		this.sendMetric('PageLoadTime', pageLoadTime.toString());
	}

	collectNavigationTiming() {
		window.addEventListener('load', () => {
			const navigationEntry = performance.getEntriesByType('navigation')[0] as PerformanceResourceTiming;

			if (navigationEntry) {
				const ttfb = navigationEntry?.responseStart - navigationEntry.startTime;
				this.sendMetric('TimeToFirstByte', ttfb.toString());
			} else {
				throw new Error('No navigation entries for navigation timing');
			}
		});
	}

	collectPaintTiming() {
		const paintEntries = performance.getEntriesByType('paint');
		const lastEntry = paintEntries[paintEntries.length - 1];

		if (lastEntry.name === 'first-paint') {
			this.sendMetric('FirstPaint', lastEntry.startTime.toString());
		} else if (lastEntry.name === 'first-contentful-paint') {
			this.sendMetric('FirstContentfulPaint', lastEntry.startTime.toString());
		}

		if ('PerformanceObserver' in window) {
			const observer = new PerformanceObserver((list) => {
				list.getEntries().forEach((perfEntry) => {
					if (perfEntry.entryType === 'largest-contentful-paint') {
					}
				});

				const entries = list.getEntries();
				const lastEntry = entries[entries.length - 1] as LargestContentfulPaint;
				this.sendMetric('LargestContentfulPaint', lastEntry.renderTime.toString());
			});
			observer.observe({
				type: 'largest-contentful-paint',
				buffered: true,
			});
		} else {
			throw Error('PerformanceObserver is not supported');
		}
	}

	sendMetric(metricName: string, metricValue: string, type = 'Internal') {
		const payload = {
			metricName,
			metricValue,
			type,
			measuredAt: new Date().toISOString(),
		};

		fetch(`${this.#baseUrl}/measurements/${this.#projectId}/client`, {
			method: 'POST',
			headers: { 'Content-Type': 'application/json' },
			body: JSON.stringify(payload),
			keepalive: true,
		}).catch((error) => {
			console.error('Failed to send metric:', error);
			throw error;
		});
	}
}
