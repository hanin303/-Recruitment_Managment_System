import { Injectable } from '@angular/core';
import { HttpClient , HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import { questionList } from '../Models/questions';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class QuestionsService {

  private baseUrl = 'http://localhost:3800/Questions';
  constructor(private http: HttpClient,private authService : AuthService) { }

  getQuestionsList(): Observable<questionList[]> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
    return this.http.get<questionList[]>(`${this.baseUrl}`,{headers:httpHeaders});
   }
  getQuestions(id: number): Observable<questionList> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
    return this.http.get<questionList>(`${this.baseUrl}/${id}`,{headers:httpHeaders});
  }

   createQuestions(questions: Object): Observable<Object> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
     return this.http.post(`${this.baseUrl}`, questions,{headers:httpHeaders});
   }

   updateQuestions(id: number, value: any): Observable<Object> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
     return this.http.put(`${this.baseUrl}/${id}`, value,{headers:httpHeaders});
   }

   deleteQuestions(id: number): Observable<any> {
    let jwt = this.authService.getToken();
    jwt = "Bearer "+jwt;
    let httpHeaders = new HttpHeaders({"Authorization":jwt}) ;
     return this.http.delete(`${this.baseUrl}/${id}`,{headers:httpHeaders});
   }


}
