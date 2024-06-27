package java

public class Main {
    public static void main(String[] args) {
        SistemaBioSmartDrive sistema = new SistemaBioSmartDrive(1, "BioSmartDrive");

        Veiculo veiculo1 = new Veiculo(1, "S10", 2020, "Biodiesel");
        Sensor sensor1 = new Sensor(1, "Pressão de Combustível");
        veiculo1.adicionarSensor(sensor1);

        sistema.adicionarVeiculo(veiculo1);

        Usuario usuario = new Usuario(1, "João", "joao@example.com", "senha123");
        usuario.fazerLogin();

        sistema.iniciarMonitoramento();
        Relatorio relatorio = sistema.gerarRelatorio();
        usuario.visualizarRelatorio(relatorio);

        sistema.pararMonitoramento();
    }
}