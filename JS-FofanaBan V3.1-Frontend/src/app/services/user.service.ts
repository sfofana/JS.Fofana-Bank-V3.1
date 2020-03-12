import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private connection = environment.connection;
  private authUrl = environment.authUrl;
  private accountUrl = environment.accountUrl;
  private depositUrl = environment.depositUrl;
  private withdrawUrl = environment.withdrawUrl;
  private transferUrl = environment.transferUrl;
  private money: Array<number> = [10, 20, 50, 100, 200, 500, 1000];

  constructor(private http:HttpClient) { }

  testConnection(): any {
    return this.http.get(this.connection);
  }

  // Auth endpoints
  authentication(user: User): Observable<User>{
    return this.http.post<User>(this.authUrl, user);
  }

  // Account endpoints
  currentAccount(user:User): Observable<User> {
    return this.http.post<User>(this.accountUrl, user);
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.authUrl);
  }

  updateUser(user:User): Observable<User> {
    return this.http.put<User>(this.authUrl, user);
  }

  // Deposit endpoints
  currentDeposit(user:User): Observable<User> {
    return this.http.post<User>(this.depositUrl, user);
  }

  updateDeposit(user:User): Observable<User> {
    return this.http.put<User>(this.depositUrl, user);
  }

  // Withdraw endpoints
  currentWithdraw(user:User): Observable<User> {
    return this.http.post<User>(this.depositUrl, user);
  }

  updateWithdraw(user:User): Observable<User> {
    return this.http.put<User>(this.depositUrl, user);
  }

  // Transfer endpoints
  currentTransfer(user:User): Observable<User> {
    return this.http.post<User>(this.depositUrl, user);
  }

  updateTransfer(user:User): Observable<User> {
    return this.http.put<User>(this.depositUrl, user);
  }

  getWidthdrawAmounts(){
    return this.money;
  }
}
