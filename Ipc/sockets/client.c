#include <stdio.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <unistd.h>
#include <string.h>

int main() {
    int client_fd;
    struct sockaddr_un addr;
    char buffer[100];

    client_fd = socket(AF_UNIX, SOCK_STREAM, 0);

    addr.sun_family = AF_UNIX;
    strcpy(addr.sun_path, "ipc_socket");

    connect(client_fd, (struct sockaddr*)&addr, sizeof(addr));

    write(client_fd, "Fine - From the client", 22);
    read(client_fd, buffer, sizeof(buffer));

    printf("Client received: %s\n", buffer);

    close(client_fd);
    return 0;
}
