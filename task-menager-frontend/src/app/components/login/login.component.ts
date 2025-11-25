import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule,NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
username:string='';
password:string='';
error:string='';

constructor(private authService:AuthService,private router:Router){}

onLogin(): void {
  this.authService.login(this.username, this.password).subscribe({
    next: () => {
      window.location.href = 'http://localhost:8081/users';
    },
    error: (err) => {
      this.error = err.message;
    }
  });
}

}
