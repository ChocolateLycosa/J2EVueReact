import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { HttpResources } from "src/app/resources/HttpResources";

export abstract class HttpService<T, ID> {
  constructor(protected http: HttpClient, private controller: string) {}

  protected get url(): string { return `${HttpResources.BASE_URL}/${this.controller}`};

  public get(id: ID): Observable<T> {
    return this.http.get<T>(`${this.url}/${id}`);
  }

  public getAll(): Observable<T[]> {
    return this.http.get<T[]>(`${this.url}`);
  }

  public post(obj: T): Observable<T> {
    return this.http.post<T>(`${this.url}`, obj);
  }

  public put(obj: T): Observable<T> {
    return this.http.put<T>(`${this.url}`, obj);
  }

  public patch(obj: T): Observable<T> {
    return this.http.patch<T>(`${this.url}`, obj);
  }

  public delete(id: ID): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
