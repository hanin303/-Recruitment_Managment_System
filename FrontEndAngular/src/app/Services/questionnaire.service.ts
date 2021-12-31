import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Questionnaire } from '../Models/questionnaire';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class QuestionnaireService {
  private baseUrl = 'http://localhost:3800/Questionnaire';

  constructor(private http: HttpClient,private authService : AuthService) { }

  getQuestionnaireList(): Observable<Questionnaire[]> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
    return this.http.get<Questionnaire[]>(`${this.baseUrl}`,{headers:httpHeaders});
   }
  getQuestionnaire(id: number): Observable<Questionnaire> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
    return this.http.get<Questionnaire>(`${this.baseUrl}/${id}`,{headers:httpHeaders});
  }

   createQuestionnaire(questionnaire: Object): Observable<Object> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
     return this.http.post(`${this.baseUrl}`, questionnaire,{headers:httpHeaders});
   }

   updateQuestionnaire(id: number, value: any): Observable<Object> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
     return this.http.put(`${this.baseUrl}/${id}`, value,{headers:httpHeaders});
   }

   deleteQuestionnaire(id: number): Observable<any> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
     return this.http.delete(`${this.baseUrl}/${id}`,{headers:httpHeaders});
   }


}
