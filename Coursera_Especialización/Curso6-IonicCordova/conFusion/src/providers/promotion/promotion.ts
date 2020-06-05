import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';

import { baseURL } from '../../shared/baseurl';
import { ProcessHttpmsgProvider } from '../process-httpmsg/process-httpmsg';
import { Promotion } from '../../shared/promotion';

import { map, catchError } from 'rxjs/operators';

@Injectable()
export class PromotionProvider {

  constructor(public http: HttpClient, private processHttpmsgService: ProcessHttpmsgProvider ) {
    console.log('Hello PromotionProvider Provider');
  }

  getPromotions(): Observable<Promotion[] | any> {
  	return this.http.get(baseURL + 'promotions')
  	.pipe(catchError(this.processHttpmsgService.handleError));
  }

  getPromotion(id: number): Observable<Promotion | any> {
  	return this.http.get<Promotion>(baseURL + 'promotions/' + id)
  	.pipe(catchError(this.processHttpmsgService.handleError));
  }

  getFeaturedPromotion(): Observable<Promotion | any> {
  	return this.http.get<Promotion[]>(baseURL + 'promotions?featured=true')
  	.pipe(map(res => res[0] ))
  	.pipe(catchError(this.processHttpmsgService.handleError));
  }
}