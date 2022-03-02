import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { Book } from './model';

@Injectable()
export class GoodreadService {

  constructor(private http: HttpClient) { }

  getAllBooks(limit: number, offset: number): Promise<Book[]> {
    const queryParams = new HttpParams()
      .set("limit", limit)
      .set("offset", offset);
    return lastValueFrom(
      this.http.get<Book[]>("/api/books", {params: queryParams})
    ) 
  }

}
