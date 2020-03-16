import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { AppComponent } from 'src/app/app.component';
import { SubjectService } from 'src/app/services/subject.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.scss']
})
export class DepositComponent implements OnInit, OnDestroy {

  private user = new User();
  private amount: number = 0;
  private updateAmount: number;
  private option: string;
  private success: string;
  private invalid: string;

  constructor(
    private service: UserService, 
    private session: AppComponent,
    private memory: SubjectService
    ) { }

  ngOnInit() {
    this.service.currentDeposit(this.session.user).subscribe(data=>this.user=data);
  }

  deposit(): void{
    if(this.option == 'checking'){
      this.updateAmount = this.user.checking.amount + this.amount;
      this.user.checking.amount = this.updateAmount;
      this.service.updateDeposit(this.user)
      .pipe(takeUntil(this.memory.unsubscribe))
      .subscribe(data=>this.user=data);
      this.memory.changedInfo(this.user);
      this.success='Successfully Deposited $'+this.amount+' to Checking Account';
      this.invalid ="";
    }
    if(this.option == 'saving'){
      this.updateAmount = this.user.saving.amount + this.amount;
      this.user.saving.amount = this.updateAmount;
      this.service.updateDeposit(this.user)
      .pipe(takeUntil(this.memory.unsubscribe))
      .subscribe(data=>this.user=data);
      this.memory.changedInfo(this.user);
      this.success='Successfully Deposited $'+this.amount+' to Saving Account';
      this.invalid ="";
    }
    if(!this.option) {
      this.invalid='Error with Deposit';
      this.success ="";
    };
  }

  select(option: any){
    this.option = option.target.value;
    console.log(this.option);
    console.dir(this.user);
  }

  reset(){
    this.amount=0;
  }

  ngOnDestroy(): void {
    this.memory.unsubscribe.next();
    this.memory.unsubscribe.complete();
  }
}
