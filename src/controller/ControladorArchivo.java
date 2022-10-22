package controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControladorArchivo {
	private String ruta;

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public ControladorArchivo() {
		buscarArchivo();
	}

	public List leerArchivo() {
		List cellDataList = new ArrayList();
		try (FileInputStream file = new FileInputStream(new File(ruta))) {
			XSSFWorkbook worbook = new XSSFWorkbook(file);
			XSSFSheet sheet = worbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				Cell cell;
				 List cellTempList = new ArrayList();
				while (cellIterator.hasNext()) {
					cell = cellIterator.next();
					cellTempList.add(cell.getStringCellValue());
				}
				cellDataList.add(cellTempList);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return cellDataList;
	}

	public void buscarArchivo() {
		try {
			JFileChooser buscador = new JFileChooser("./");
			FileFilter filtroExcel = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
			buscador.addChoosableFileFilter(filtroExcel);
			buscador.setFileFilter(filtroExcel);
			buscador.setAcceptAllFileFilterUsed(false);

			buscador.showOpenDialog(buscador);
			ruta = buscador.getSelectedFile().getAbsolutePath();
		} catch (Exception ex) {
		}
	}
}
