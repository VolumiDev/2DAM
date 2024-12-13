import { ChangeDetectorRef, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class E21Service {

  constructor(private cdr: ChangeDetectorRef) { }
  numero: number = 0;
  flag: boolean = false;
  visible: boolean = true;

  numerosHijo:number[] = [];
  numeroPadre:number[] = [];

  asignarNumero(num: string): void{
    this.numero = parseInt(num);
  }

  addition(array: number[]): void{
    this.visible = false
    array.push(this.numero)
    this.numero++;

    if(this.flag){
      this.flag = false;
    }else{
      this.flag = true;
    }
    console.log(this.flag)
    console.log(this.numeroPadre)
    console.log(this.numerosHijo)

    this.cdr.detectChanges();
  }

  get getFlag(){
    return this.flag;
  }
}
