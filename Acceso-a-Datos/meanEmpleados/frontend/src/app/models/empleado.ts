// import {v4 as uuid} from 'uuid';
export class Empleado {
    _id: string;
    nombre: string;
    cargo: string
    departamento: string;
    salario: number;

    constructor(){
        this._id = '';
        this.nombre = '';
        this.cargo = '';
        this.departamento = '';
        this.salario = 0;
    }
    
}
