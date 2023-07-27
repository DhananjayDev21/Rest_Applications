import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/EntityClasses/customer';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  customer: Customer = new Customer(0, '', ''); // Assuming the Customer class has a constructor with three parameters: id, name, email
  msg: string = '';



  constructor(private service: CustomerService,
    private route: ActivatedRoute,
    private router: Router
  ) { }


  ngOnInit(): void {

    let id = this.route.snapshot.params['id'];
    this.loadCustomer(id);

  }



  loadCustomer(id: number) {
    this.service.getCustomerById(id).subscribe({
      next: (data) => {
        this.customer = data;
      },
      error: (err) => console.log(err),
      // complete: () => console.info('Student received successfully'),
    });
  }

  updateCustomer() {

    this.service.updateCustomer(this.customer.id, this.customer).subscribe({
      next: (data) => {
        this.msg = data;
        alert(this.msg);
        this.router.navigate(['/all']);
      },
      error: (err) => console.log(err),
      complete: () => console.info('Student updated successfully'),
    });
  }


}
