// import { Component } from '@angular/core';
// import { Router } from '@angular/router';
// import { Customer } from 'src/app/EntityClasses/customer';
// import { CustomerService } from 'src/app/Services/customer.service';

// @Component({
//   selector: 'app-all',
//   templateUrl: './all.component.html',
//   styleUrls: ['./all.component.css']
// })
// export class AllComponent {

//   customers: Customer[] = [];


//   constructor(private service: CustomerService, private router: Router) { }

//   getAllCustomer(){

//     this.service.getAllCustomer().subscribe({
//       next: (data) => (this.customers = data),
//       error: (err) => console.log(err),
//       complete: () => console.info('View Rendered'),
//     });

//     };
//   }


import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/EntityClasses/customer';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {
  customers: Customer[] = [];
  message: any = '';
  constructor(private service: CustomerService, private router: Router) { }

  ngOnInit() {
    this.getAllCustomer();
  }

  getAllCustomer() {
    this.service.getAllCustomer().subscribe({
      next: (data) => (this.customers = data),
      error: (err) => console.log(err),
      complete: () => console.info('View Rendered'),
    });
  }

  // deleteCustomer(id: number) {
  //   this.service.deleteCustomer(id).subscribe({
  //     next: (data) => {
  //       console.log(data);
  //       this.message = data;
  //       this.getAllCustomer();
  //     },
  //     error: (err) => console.log(err),
  //     complete: () => console.info('complete'),
  //   });
  // }

  deleteCustomer(id: number) {
    this.service.deleteCustomer(id).subscribe(
      (data) => {
        console.log(data);
        this.message = data;
        this.getAllCustomer();
      },
      (err) => console.log(err),
      () => console.info('complete')
    );
  }
  
  updateCustomer(id:number){

    this.router.navigate(['update',id]);

  }

  viewCustomer(id:number){

    this.router.navigate(['view',id]);
  }

}
