import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl="http://localhost:8081/login"

  constructor(private http:HttpClient) { }

login(username:string,password:string){
  const body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password);

    const headers=new HttpHeaders({
      'Content-Type':'application/x-www-form-urlencoded'
    })
    return this.http.post(this.loginUrl,body.toString(),{
      headers:headers,
      withCredentials:true
    }).pipe(
      catchError(this.handleError)
    );

}



private handleError(error: HttpErrorResponse) {
    let errorMsg = 'Wystąpił błąd!';
    if (error.status === 401) {
      errorMsg = 'Nieprawidłowy login lub hasło.';
    } else if (error.error instanceof ErrorEvent) {
      errorMsg = `Błąd klienta: ${error.error.message}`;
    } else {
      errorMsg = `Błąd serwera: ${error.status} - ${error.message}`;
    }
    return throwError(() => new Error(errorMsg));
  }
}
