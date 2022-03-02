import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

import { GoodreadService } from '../goodread.service';
import { Book } from '../model';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  form!: FormGroup;
  books: Book[] = [];

  constructor(private fb: FormBuilder, private grSvc: GoodreadService, private router: Router) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.form = this.fb.group({
      // title: this.fb.control(''),
      limit: this.fb.control(''),
      offset: this.fb.control(''),
    });
  }

  displayBooks() {
    const limit = this.form.get('limit')?.value;
    const offset = this.form.get('offset')?.value;
    this.grSvc.getAllBooks(limit, offset)
      .then(result => result.map(book => this.books.push(book as Book)));
    console.info(this.books);
    this.form.reset();
  }

  again() {
    this.books = [];
  }

}
