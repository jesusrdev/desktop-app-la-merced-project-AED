package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Factura;
import clases.StockProducto;


public class ArregloStock {

	// Atributo privado
		private ArrayList<StockProducto> as;

		// Constructor
		public ArregloStock() {
			as = new ArrayList<StockProducto>();
//			try {
////				cargarStocks();
////				obtener(0);
//
//			} catch (Exception e) {
				as.add(new StockProducto("Maiz Amarillo", 2275.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Maiz Chancado", 0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Torta de Soya", 79450.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Torta de Girasol", 850.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Polvillo", 89198.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Afrecho", 45594.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Integral", 155137.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Torta de Palmiste", 70920.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Cascarilla Palmiste", 50684.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Sal", 6775.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Bicarbonato", 9.69,0,0, 0, 7, 2023));
				as.add(new StockProducto("Pancamel", 7893.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Prime 100", 50.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Progras", 0.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Fosfato", 612.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("B. Aves", 0.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Melaza", 3236.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Procreating", 1.32,0,0, 0, 7, 2023));
				as.add(new StockProducto("Toxibond", 148.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Calcio", 18123.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Metionina", 50.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Pre. Postura", 3.19,0,0, 0, 7, 2023));
				as.add(new StockProducto("B. Ganado", 0.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Lisina", 26.48,0,0, 0, 7, 2023));
				as.add(new StockProducto("Colina", 61.82,0,0, 0, 7, 2023));
				as.add(new StockProducto("Fungiker", 25.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("P. Pollo", 40.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Aceite", 328.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Novafil", 31.89,0,0, 0, 7, 2023));
				as.add(new StockProducto("Coccidiostato", 13.62,0,0, 0, 7, 2023));
				as.add(new StockProducto("Zimbacitracina", 34.23,0,0, 0, 7, 2023));
				as.add(new StockProducto("Urea", 22.63,0,0, 0, 7, 2023));
				as.add(new StockProducto("Nucleo de Cerdo", 191.32,0,0, 0, 7, 2023));
				as.add(new StockProducto("DDGS", 0.0,0,0, 0, 7, 2023));
				as.add(new StockProducto("Pepa de Algodon", 360.0,0,0, 0, 7, 2023));
				
//			}
		}

		// Methods
		public void adicionar(StockProducto x) {
			as.add(x);
		}

		public int tamanio() {
			return as.size();
		}

		public StockProducto obtener(int i) {
			return as.get(i);
		}


		public void eliminar(StockProducto x) {
			as.remove(x);
		}

		
		public ArrayList<StockProducto> filtrarStocksPorFecha(int mes, int anio) {
			ArrayList<StockProducto> arreglo = new ArrayList<StockProducto>(); 
			StockProducto stock;
			
			for (int i = 0; i < tamanio(); i++) {
				stock = obtener(i);
				if ( stock.getMesStock() == mes && stock.getAnioStock() == anio ) {
					arreglo.add(stock);
				}
			}
			
			return arreglo;
		}
		
		
		
		public void generarInformacionDeLosStocks(ArregloCompras compras, ArregloFacturas facturas) {
			for (int i = 0; i < tamanio(); i++) {
				StockProducto x = obtener(i);
				double stockMesAnterior =  buscarStockFinalDelMesAnterior(x);
				
				if (stockMesAnterior > 0) {
					x.setStockInicial(stockMesAnterior);
				}
				
				x.setIngresos(x.buscarIngresosDelMes(compras));
				x.setEgresos(x.buscarEgresosDelMes(facturas));
				x.calcularStockFinal();
			}
			
			grabarStocks();
		}
		
		public double buscarStockFinalDelMesAnterior(StockProducto stock) {
			String nombre = stock.getNombreProducto();
			int mes = stock.getMesStock() -1;
			int anio = stock.getAnioStock(); 				
			if (mes < 0) {
				mes = 11;
				anio = stock.getAnioStock() -1; 
			}
			
			for (int i = 0; i < tamanio(); i++) {
				if ( 	nombre.equals(obtener(i).getNombreProducto()) && 
						mes == obtener(i).getMesStock() &&
						anio == obtener(i).getAnioStock()
					) {
					return obtener(i).getStockFinal();
				}
			}
			
			return 0.0;
		}
		
		
		public ArrayList<StockProducto> ventasTotalesDeLosProductosEnUnAnio(int anio, ArregloFacturas af, ArregloProductos ap) {
			
			ArrayList<StockProducto> arreglo = new ArrayList<StockProducto>(); 
			StockProducto stock;
			String[] lista = ap.productosComboBox();
			
			for (int i = 0; i < ap.tamanio(); i++) {
				arreglo.add(new StockProducto(lista[i], 0, anio));
				
				stock = arreglo.get(i);
				
				stock.setEgresos(stock.buscarEgresosDelAnio(af));
			}
			
			
			return arreglo;
		}
		

		// Metodos para trabajar cn rachivos
		public void grabarStocks() {
			try {
				PrintWriter pw;
				StockProducto x;
				String linea;
				pw = new PrintWriter(new FileWriter("Stock.txt"));
				for (int i = 0; i < as.size(); i++) {
					x = obtener(i);
					linea = x.getNombreProducto() + ";" + x.getStockInicial() + ";" + x.getIngresos() + ";" + x.getEgresos() + ";"
							+ x.getStockFinal() + ";" + x.getMesStock() + ";" + x.getAnioStock();
					pw.println(linea);
				}
				pw.close();
			} catch (Exception e) {
			}
		}

		public void cargarStocks() {
			try {
				BufferedReader br;
				String linea, s[], nombreProducto;
				double stockInicial, ingresos, egresos, stockFinal;
				int mesStock, anioStock;

				br = new BufferedReader(new FileReader("Stock.txt"));

				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					nombreProducto = s[0];
					stockInicial = Double.parseDouble(s[1]);
					ingresos = Double.parseDouble(s[2]);
					egresos = Double.parseDouble(s[3]);
					stockFinal = Double.parseDouble(s[4]);
					mesStock = Integer.parseInt(s[5]);
					anioStock = Integer.parseInt(s[6]);

					as.add(
							new StockProducto(nombreProducto, stockInicial, ingresos, egresos, stockFinal, mesStock, anioStock));
				}
				br.close();
			} catch (Exception e) {
			}
		}
		

}
