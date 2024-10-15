#include <stdio.h>
#include <unistd.h>
#include <signal.h>

void manejador(int signal){
    printf("Señal capturada %d\n, signal");
}

void main(){
    signal(SIGINT,manejador);

    while(1){
        printf("Predsiona CTRL+C para recibir la señal\n");
    }
}