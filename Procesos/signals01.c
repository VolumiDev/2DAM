#include <stdio.h> //MANIPULA LA ALIDA Y ENTRADA ESTANDAR
#include <unistd.h> //MANEJA TODO LO RELACIONADO CON LA GESTION DE PROCESOS
#include <sys/wait.h> //RECURSOS QUE VAMOS A EMPLEAR CON LOS PROCESOS DEL SISTEMA
#include <signal.h> //MANEJA LA LIBRERIA DE LAS SIGNALS
#include <fcntl.h> //LIBRERIA QUE CONTROLA EL EXIT
#include <stdlib.h> // GESTIONA LAS ENTRADAS Y SALIDAS, VA JUNTO CON STDIO

//Con este creamos un proceso con fork() (creamos padre e hijo) y vamos a
// hacer que el padre despues de 2 seg finalice la ejecucion del hijo
// lanzando una señal y realizando un KILL


void manejador(int senal){
    printf("He recibido la señal %d\n", señal)
}




void main(){

    //CREACION DE PROCESO
    pid_t proceso;
    proceso = fork();

    printf("Iniciamos programa\n")

    switch(proceso){
        case -1:  //ERROR
            printf("Se ha producido un error en la creacion del proceso\n")
            exit(-1);
        break;
        case 0: // HIJO
            signal(SIGUSR1, manejador);
            while(1){
                printf("Hola soy el hijo\n")
            }
        break;
        default: //PADRE
            sleep(5);
            kill(proceso, SIGUSR1)

            
        break;
    }

}
