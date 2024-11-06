using System.Text;
using System.Windows;
using iTextSharp.text;




using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.IO;
using iTextSharp.text.pdf;
using Paragraph = iTextSharp.text.Paragraph;
using System.IO.Enumeration;
using FirebaseAdmin;
using Google.Apis.Auth.OAuth2;
using Firebase.Storage;
using Path = System.IO.Path;

namespace pdfmanager
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {

            InitializeComponent();
            InicializarFirebase();
        }

        private void InicializarFirebase()
        {

            FirebaseApp.Create(new AppOptions()
            {
                Credential = 
                GoogleCredential.FromFile(
                    "C:\\Users\\Alumno\\Downloads\\chatbd-bd7c0-firebase-adminsdk-poo69-1e84d1992a.json")

               
            });
        }

        private async Task<string> subirpdf (string rutaPDF)
        {

            var storage = new FirebaseStorage("gs://chatbd-bd7c0.appspot.com", new FirebaseStorageOptions()
            {
                //https://oauth2.googleapis.com/token
                AuthTokenAsyncFactory = () => Task.FromResult("https://oauth2.googleapis.com/token"),
                ThrowOnCancel =true            
            
            });

            using (var stream = File.OpenRead(rutaPDF))
            {
                var nombreArchivo = Path.GetFileName(rutaPDF);


                var url =await storage.Child("pdfs").Child(nombreArchivo).PutAsync(stream);


                return url;
            }


        }

        private void genPdf(object sender, RoutedEventArgs e)
        {
            string rutaPDF = "archivoGenerado.pdf";
            GenerarPDF(rutaPDF);
            MessageBox.Show("PDF generado con exito en: " + rutaPDF);
        }

        private async void GenerarPDF(string rutaPDF)
        {

            using (FileStream fs = new FileStream(rutaPDF, FileMode.Create)) { 
            
            Document doc=new Document();
                PdfWriter.GetInstance(doc,fs);

                doc.Open();

                doc.NewPage();

                doc.Add(new Paragraph("Esto es un documento de pdf"));

                string rutaimg = "C:\\Users\\Alumno\\Desktop\\mini.png";

                if (File.Exists(rutaimg)) { 
                
                iTextSharp.text.Image imagen=iTextSharp.text.Image.GetInstance(rutaimg);
                    imagen.ScaleToFit(300f, 300f);
                    imagen.Alignment=Element.ALIGN_CENTER;

                    doc.Add(imagen);
                
                }                
                try { doc.Close();
                    string url = await subirpdf(rutaPDF);
                    MessageBox.Show("se ha subido el pdf");
                }
                catch (Exception E) { }
               
            
            }

            
        }

        private void openPdf(object sender, RoutedEventArgs e)
        {
            string rutaPDF = "archivoGenerado.pdf";
            if (File.Exists(rutaPDF)) {
                System.Diagnostics.Process.Start(new System.Diagnostics.ProcessStartInfo
                {
                    FileName = rutaPDF,
                    UseShellExecute = true

                });
            }
            else
            {
                MessageBox.Show("El archivo pdf no existe");
            }
        }
    }

    
}