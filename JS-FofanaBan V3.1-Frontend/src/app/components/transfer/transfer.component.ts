import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { AppComponent } from 'src/app/app.component';
import { SubjectService } from 'src/app/services/subject.service';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss']
})
export class TransferComponent implements OnInit, OnDestroy {

  private user = new User();
  private amount: number = 0;
  private updateAmount: number;
  private lostAmount: number;
  private optionFrom: string;
  private optionTo: string;
  private success: string;
  private invalid: string;

  constructor(
    private service: UserService, 
    private session: AppComponent,
    private memory: SubjectService
    ) { }

  ngOnInit() {
    this.service.currentTransfer(this.session.user).subscribe(data=>this.user=data);
  }

  transfer(): void{
    console.dir(this.user);
    if(this.optionFrom == 'checking'){
      this.lostAmount = this.user.checking.amount - this.amount;
      this.updateAmount = this.user.saving.amount + this.amount;
      this.user.checking.amount = this.lostAmount;
      this.user.saving.amount = this.updateAmount;
      this.service.updateTransfer(this.user)
      .pipe(takeUntil(this.memory.unsubscribe))
      .subscribe(data=>this.user=data);
      this.memory.changedInfo(this.user);
      this.success='Successfully Transfer $'+this.amount+' from Checking Account';
      this.invalid ="";
    }
    if(this.optionFrom == 'saving'){
      this.lostAmount = this.user.saving.amount - this.amount;
      this.updateAmount = this.user.checking.amount + this.amount;
      this.user.saving.amount = this.lostAmount;
      this.user.checking.amount = this.updateAmount;
      this.service.updateTransfer(this.user)
      .pipe(takeUntil(this.memory.unsubscribe))
      .subscribe(data=>this.user=data);
      this.memory.changedInfo(this.user);
      this.success='Successfully Transfer $'+this.amount+' from Saving Account';
      this.invalid ="";
    }
    if(!(this.optionFrom || this.optionTo)) {
      this.invalid='Error with Transfer';
      this.success ="";
    }
    if(this.optionFrom == this.optionTo) {
      this.invalid='To make a deposit see our Deposit Section';
      this.success ="";
    };
  }

  selectFrom(option: any){
    this.optionFrom = option.target.value;
    console.log(this.optionFrom);
  }

  selectTo(option: any){
    this.optionTo = option.target.value;
    console.log(this.optionTo);
  }

  reset(){
    this.amount=0;
  }

  ngOnDestroy(): void {
    this.memory.unsubscribe.next();
    this.memory.unsubscribe.complete();
  }
}
