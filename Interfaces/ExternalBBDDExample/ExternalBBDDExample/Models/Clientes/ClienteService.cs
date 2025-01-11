using System.Text;
using System.Text.Json;

namespace ExternalBBDDExample.Models.Clientes
{
    public class ClienteService
    {
        private readonly HttpClient _httpClient;
        public ClienteService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public async Task<bool> CrearClienteAsync( Cliente cliente)
        {
            var json = JsonSerializer.Serialize(cliente);
            var content = new StringContent(json, Encoding.UTF8, "application/json");

            try
            {
                var response = await _httpClient.PostAsync("http://mimartinezgmg.com/perfumados/altacliente.php", content);
                response.EnsureSuccessStatusCode();
                return response.IsSuccessStatusCode;
            }
            catch (HttpRequestException ex) { 
                Console.WriteLine($"Error: {ex}");
                return false;
            }
        }

        
    }
}
