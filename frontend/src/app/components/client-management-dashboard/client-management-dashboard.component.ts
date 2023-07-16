import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-client-management-dashboard',
  templateUrl: './client-management-dashboard.component.html',
  styleUrls: ['./client-management-dashboard.component.scss']
})
export class ClientMgmtDashboardComponent implements OnInit {

  roles: string[] = [];
  constructor() {
  }

  ngOnInit(): void {
  }
}
