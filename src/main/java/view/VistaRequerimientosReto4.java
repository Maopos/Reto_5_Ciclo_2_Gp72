package view;

import controller.ControladorRequerimientosReto4;
import model.vo.LideresMayorSalario;
import model.vo.LideresProyectosEmblematicos;
import model.vo.MaterialRankeadoImportado;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaRequerimientosReto4 extends JFrame {

	public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;


	
	public VistaRequerimientosReto4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reto 5");
		lblNewLabel.setBounds(28, 6, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mauricio Posada Gp72");
		lblNewLabel_1.setBounds(28, 34, 208, 16);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 70, 737, 455);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btn_consulta_1 = new JButton("Consulta 1");				// Consulta 1
		btn_consulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento1();
			}
		});
		btn_consulta_1.setBounds(28, 537, 117, 29);
		contentPane.add(btn_consulta_1);
		
		JButton btnNewButton = new JButton("Consulta 2");				// Consulta 2
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento3();
			}
		});
		btnNewButton.setBounds(157, 537, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consulta 3");				// Consulta 3
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				requerimiento4();
			}
		});
		btnNewButton_1.setBounds(286, 537, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpiar");				// Limpiar
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText("");
				
			}
		});
		btnNewButton_2.setBounds(648, 537, 117, 29);
		contentPane.add(btnNewButton_2);
	}
	
public void requerimiento1(){
    

        try{

            ArrayList<LideresMayorSalario> rankingLideresMayorSalario = controlador.consultarLideresMayorSalarios();

            //Encabezado del resultado
            
            String frase = "*** Lideres con mayor salario ***\n\nID_Lider  Nombre  Primer_Apellido\n\n";
            
            //Cada VO cargado, mostrarlo en la vista
            for (LideresMayorSalario lideresMayors : rankingLideresMayorSalario) {
            	
            	
                frase += lideresMayors.getIdLider();
                frase += "           ";
                frase += lideresMayors.getNombre();
                frase += "         ";
                frase += lideresMayors.getPrimerApellido();
                frase += "\n";
                  
            }
            
            textArea.setText(frase);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

public void requerimiento3(){

          

    try{

        ArrayList<LideresProyectosEmblematicos> rankingProyectosEmblematicos = controlador.consultarLideresProyectosEmblematicos();

        //Encabezado del resultado
        String frase = "*** Lideres proyectos emblemáticos ***\n\nId_Lider	Id_Proyecto	Id_Tipo\n\n";
        
        //Cada VO cargado, mostrarlo en la vista
        for (LideresProyectosEmblematicos lideresProyectosE : rankingProyectosEmblematicos) {
            
        	frase += lideresProyectosE.getIdLider();
        	frase += "	";
        	frase += lideresProyectosE.getIdProyecto();
        	frase += "	";
        	frase += lideresProyectosE.getIdTipo();
        	frase += "\n";
              
        }
        
        textArea.setText(frase);

    }catch(SQLException e){
        System.err.println("Ha ocurrido un error!"+e.getMessage());
    }

}

public void requerimiento4(){

    String resultado = "*** Productos importados ***\n\n";      

    try{
        
        ArrayList<MaterialRankeadoImportado> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosImportados();

        //Cada VO cargado, mostrarlo en la vista
        for (MaterialRankeadoImportado materialImportado : rankingMaterialesImportados) {
        	
        	resultado += "El producto de ID ";
        	resultado += materialImportado.getIdMaterial();
        	resultado += " de descripción: ";
        	resultado += materialImportado.getNombreMaterial();
        	resultado += "de tipo importado(a), tiene un precio de ";
        	resultado += materialImportado.getPrecioUnidad();
      
        	resultado += "\n"  ;
        }

    }catch(SQLException e){
        System.err.println("Ha ocurrido un error!"+e.getMessage());
    }
    
    textArea.setText(resultado);
}
}
