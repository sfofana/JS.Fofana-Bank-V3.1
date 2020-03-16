import { Component, OnInit, OnDestroy } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { SubjectService } from 'src/app/services/subject.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.scss']
})
export class ClientComponent implements OnInit, OnDestroy {

  private auth = new User();
  private user = new User();
  private view;

  constructor(
    private session: AppComponent, 
    private service: UserService, 
    private router: Router,
    private memory: SubjectService
    ) { }

  ngOnInit() {
    this.authentication();
  }

  toggle(tab:string){
    this.view = tab;
    console.log(tab);
  }

  authentication(){
    if(!this.session.canLogout){
      this.router.navigate(['']);
    }
    if(this.session.canLogout){
      //this.auth = this.session.user;
      this.memory.refresh
      .pipe(takeUntil(this.memory.unsubscribe))
      .subscribe(data=>{
        this.auth=data;
        this.service.currentAccount(this.auth).subscribe(data=>this.user=data);
      });
      
    }
  }

  ngOnDestroy(): void {
    this.memory.unsubscribe.next();
    this.memory.unsubscribe.complete();
  }
}
