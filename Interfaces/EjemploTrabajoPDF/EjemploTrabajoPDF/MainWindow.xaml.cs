using iTextSharp.text;
using iTextSharp.text.pdf;
using Microsoft.Win32;
using System.IO;
using FirebaseAdmin;
using Firebase.Storage;
using System.Windows;
using System.Windows.Shapes;
using Google.Apis.Auth.OAuth2;
using iTextSharp.text.pdf.parser;

namespace EjemploTrabajoPDF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void InicializarFirebase()
        {
            FirebaseApp.Create(new AppOptions()
            {
                Credential = GoogleCredential.FromFile("C:\\Users\\Alumno\\Documents\\2DAM\\Interfaces\\EjemploTrabajoPDF\\CredentialFirebaseStorage.json")
            });
        }

        private async Task<string> SubirPDFaFirebase(String rutaPDF)
        {
            var url = "";
            var storage = new FirebaseStorage("gs://tema5prueba1.appspot.com", new FirebaseStorageOptions
            {
                AuthTokenAsyncFactory = () => Task.FromResult(""),
                ThrowOnCancel = true //pueds manejar la cancelacion si fuese necesario

            });

            using(var stream = File.OpenRead(rutaPDF))
            {
                var nombre = System.IO.Path.GetFileName(rutaPDF);

                try
                {
                    url = await storage.Child("pdfs")
                        .Child(nombre)
                        .PutAsync(stream);
                    return url;
                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Ocurrió un error al generar el URL: {ex.Message}", "Error", MessageBoxButton.OK, MessageBoxImage.Error);

                }
            }
            return url;
        }

        private void btn_generarPdf_Click(object sender, RoutedEventArgs e)
        {
            string path = "archivoGenerado.pdf";
            GenerarPDF(path);
        }

        private async void GenerarPDF(string path)
        {
            using (FileStream fs = new FileStream(path, FileMode.Create)) {
                //CREAMOS UN NUEVO DOCUMENTO
                Document document = new Document();

                //CREAR UN ESCRITOR DE pdf PARA EL DOCUMENTO DEL ARCHIVO
                PdfWriter.GetInstance(document, fs);

                //ABRIR EL DUCUMENTO PARA ESCRIBIR.
                document.Open(); 

                //AGREGAR UNA PAGINA ANTES DE AÑADIR CONTENIDO
                document.NewPage();

                //AÑAADIR CONTENIDO AL DOCUMENTO
                document.Add(new iTextSharp.text.Paragraph("Este documento esta escrito desde c#"));


                /////Imagen
                string imgPath = "C:\\Users\\Alumno\\Desktop\\CV.png";
                if (File.Exists(imgPath)) 
                { 
                    iTextSharp.text.Image imagen = iTextSharp.text.Image.GetInstance(imgPath);
                    //configuramos la imagen
                    imagen.ScaleToFit(300f, 300f);
                    imagen.Alignment = Element.ALIGN_CENTER;

                    document.Add(imagen);

                }

                //CERRAMOS EL DOC
                try
                {
                    document.Close();
                    MessageBox.Show("PDF generado correctamente", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);

                }
                catch (Exception ex)
                {
                    MessageBox.Show($"Ocurrió un error al generar el PDF: {ex.Message}", "Error", MessageBoxButton.OK, MessageBoxImage.Error);

                }

                string url = await SubirPDFaFirebase(path);
            }
        }

        private void btn_abrirPdf_Click(object sender, RoutedEventArgs e)
        {
            string path = "archivoGenerado.pdf";
            if (File.Exists(path))
            {
                // ABRIR EL PDF EN EL VISOR PREDETERMINADO
                System.Diagnostics.Process.Start(new System.Diagnostics.ProcessStartInfo
                {
                    FileName = path,
                    UseShellExecute = true //Necesario para abrir el visor de pdf
                });
            }
            else
            {
                MessageBox.Show("EL fichero pdf no existe");

            }
        }

        private string rutaImagen()
        {
            string ruta = "";
            OpenFileDialog openFileDialog = new OpenFileDialog
            {
                Title = "Añadir imagen",
                Filter = "Archivos de imagen|*.jpg;*.jpeg;*.png;*.bmp;*.gif"
            };
            if(openFileDialog.ShowDialog() == true)
            {
                 ruta = openFileDialog.FileName;
            }
            return ruta;
        }
    }
}