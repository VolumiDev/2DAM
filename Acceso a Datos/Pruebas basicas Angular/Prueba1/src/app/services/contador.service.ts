import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContadorService {

  constructor(cont: number) {}

  incrementar(cont: number){
    cont++;
  }

  decrementar(cont: number){
    cont--;
  }
}
