import { ChangeDetectionStrategy, Component, HostBinding } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TuiButton } from '@taiga-ui/core';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
  standalone: true,
  imports: [RouterModule, TuiButton],
})
export class SidebarComponent {
  open = false;

  @HostBinding('class') classes = 'flex bg-white border-e';

  async signOut(): Promise<void> {
    //this.router.navigate(['/auth/login']);
  }
}
