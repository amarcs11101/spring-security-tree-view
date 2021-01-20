import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ServiceService } from '../app/service.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'microservice-app';
  jsonData : any;
  constructor(private http: HttpClient,private service: ServiceService){

  }
  fetchJsonForVehicleMicroservice() {
    this.service.fetchJsonForVehicleMicroservice().subscribe((data: any) => {
      this.jsonData = data.data;
    }), err => {
      console.log(" :: error in fetchJsonForVehicleMicroservice :: method :: " + err);
    };
  }

  fetchJsonForBookMicroservice() {
    this.service.fetchJsonForBookMicroservice().subscribe((data: any) => {
      this.jsonData = data.data;
    }), err => {
      console.log(" :: error in fetchJsonForBookMicroservice :: method :: " + err);
    };
  }

  fetchJsonForLocationMicroservice() {
    this.service.fetchJsonForLocationMicroservice().subscribe((data: any) => {
      this.jsonData = data.data;
      console.log(" :: fetchJsonForLocationMicroservice :: method :: " + this.jsonData);
    }), err => {
      console.log(" :: error in fetchJsonForLocationMicroservice :: method :: " + err);
    };
  }

  fetchJsonForCustomerMicroservice() {
    this.service.fetchJsonForCustomerMicroservice().subscribe((data: any) => {
      this.jsonData = data.data;
      console.log(" :: fetchJsonForCustomerMicroservice :: method :: " + this.jsonData);
    }), err => {
      console.log(" :: error in fetchJsonForCustomerMicroservice :: method :: " + err);
    };
  }
}
