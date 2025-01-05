import {
  ChangeDetectionStrategy,
  Component,
  HostBinding,
  inject,
} from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { TuiButton } from '@taiga-ui/core';
import { FooterComponent } from '../../shared/components/footer/footer.component';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { SidebarComponent } from '../../shared/components/sidebar/sidebar.component';

@Component({
  selector: 'volt-layout',
  standalone: true,
  templateUrl: './app-layout.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [HeaderComponent, RouterModule, SidebarComponent, FooterComponent],
})
export class AppLayoutComponent {
  readonly router = inject(Router);
  @HostBinding('class') classes = 'flex h-screen flex-col';
  sideMenuState = false;

  toggleSideMenuState(): void {
    this.sideMenuState = !this.sideMenuState;
  }
}
