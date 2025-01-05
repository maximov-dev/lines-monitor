import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Output,
} from '@angular/core';
import { TuiIcon } from '@taiga-ui/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [TuiIcon, RouterModule],
})
export class HeaderComponent {
  @Output()
  readonly menuToggle = new EventEmitter<boolean>();
}
