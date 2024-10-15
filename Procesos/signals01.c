#include <stdio.h> //MANIPULA LA ALIDA Y ENTRADA ESTANDAR
#include <unistd.h> //MANEJA TODO LO RELACIONADO CON LA GESTION DE PROCESOS
#include <signal.h> //MANEJA LA LIBRERIA DE LAS SIGNALS
#include <stdlib.h> // GESTIONA LAS ENTRADAS Y SALIDAS, VA JUNTO CON STDIO

//Con este creamos un proceso con fork() (creamos padre e hijo) y vamos a
// hacer que el padre despues de 2 seg finalice la ejecucion del hijo
// lanzando una señal y realizando un KILL


void manejador(int senal){
    printf("Hijo recibe señal %d\n", senal);
}

void main(){

    //CREACION DE PROCESO
    pid_t procesoHijo = fork();

    printf("Iniciamos programa:\n");

    switch(getpid()){
        case -1:  //ERROR
            printf("Se ha producido un error en la creacion del proceso\n");
            exit(-1);
        break;
        case 0: // HIJO
            signal(SIGUSR1, manejador);
            while(1){
                printf("Hola soy el hijo\n");
            }
        break;
        default: //PADRE
            sleep(3);
            kill(getpid(), SIGUSR1);
        break;
    }
}
