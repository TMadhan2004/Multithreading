#include <stdio.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <unistd.h>
#include <string.h>

int main() {
    int server_fd, client_fd;
    struct sockaddr_un addr;
    char buffer[100];

    server_fd = socket(AF_UNIX, SOCK_STREAM, 0);

    addr.sun_family = AF_UNIX;
    strcpy(addr.sun_path, "ipc_socket");

    bind(server_fd, (struct sockaddr*)&addr, sizeof(addr));
    listen(server_fd, 1);

    printf("Server waiting for client \n");
    client_fd = accept(server_fd, NULL, NULL);

    read(client_fd, buffer, sizeof(buffer));
    printf("Server received: %s\n", buffer);

    write(client_fd, "How are you - Message from the server", 37);

    close(client_fd);
    close(server_fd);
    unlink("ipc_socket");

    return 0;
}
