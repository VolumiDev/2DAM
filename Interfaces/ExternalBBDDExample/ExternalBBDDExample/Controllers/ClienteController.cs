using ExternalBBDDExample.Models.Clientes;
using Microsoft.AspNetCore.Mvc;

namespace ExternalBBDDExample.Controllers
{
    public class ClienteController : Controller
    {
        private readonly ClienteService _cienteService;

        public ClienteController(ClienteService cienteService)
        {
            _cienteService = cienteService;
        }

        public IActionResult Crear()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Crear(Cliente cliente)
        {
            if (ModelState.IsValid)
            {
                var resultado = await _cienteService.CrearClienteAsync(cliente);
                if (resultado)
                {
                    ViewBag.Mensaje = "Cliente regustrado con exito";
                }
                else
                {
                    ViewBag.Mensaje = "Error al registrar al usuario";
                }
            }
            return View();
        }
    }
}
