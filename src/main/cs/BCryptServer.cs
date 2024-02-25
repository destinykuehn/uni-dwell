using System.Net;
using System.Net.Sockets;
using System.Text;
using BCryptHasher;

namespace BCryptServer
{
    class BCryptServer
    {
        static void Main(string[] args)
        {
            // Creating server socket
            IPAddress ipAddress = IPAddress.Parse("127.0.0.1");
            IPEndPoint iPEndPoint = new(ipAddress, 3000);
            using Socket server = new(iPEndPoint.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
            // Binding server socket to IP and port and setting it with a backlog of 100 connections
            server.Bind(iPEndPoint);
            server.Listen(100);
            // Beginning the acceptClients loop
            acceptClients(server);
            // ReadKey() to keep the server running while accepting clients
            Console.WriteLine("Server started. Press any key to exit...");
            Console.ReadKey();
        }

        /// <summary>
        /// Method that will accept new clients connecting to server and spawn a new thread to deal with client request
        /// </summary>
        /// <param name="server"> The server socket that will accept incoming connections </param>
        /// <returns> Nothing </returns>
        static async void acceptClients(Socket server)
        {
            Console.WriteLine("Server is now accepting connections");
            while (true)
            {
                var handler = await server.AcceptAsync();
                Console.WriteLine("New connection accepted");
                Thread thread = new Thread(() => handleRequest(handler));
                thread.Start();
            }
        }
        /// <summary>
        /// Method that will receive client request and handle it, sending the requested data back to client
        /// </summary>
        /// <param name="client"> The socket representing the connection to the client </param>
        static async void handleRequest(Socket client)
        {
            var buffer = new byte[1024];
            var received = await client.ReceiveAsync(buffer, SocketFlags.None);
            string response = Encoding.UTF8.GetString(buffer, 0, received);
            Console.WriteLine(response);
            if (response.StartsWith("R_HASH")) {
                string hashedMsg = Hasher.Hash(response);
                var echoBytes = Encoding.UTF8.GetBytes(hashedMsg);
                await client.SendAsync(echoBytes, 0);
            }
            if (response.StartsWith("R_CHECK"))
            {
                // do stuff here
            }

        }
    }
}
