import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/EntityClasses/customer';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

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

}
