import excepciones.ConciertoException;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Concierto {
    private int idConcierto;
    private LocalDateTime fecha;
    private String sala;
    private List<Musico> musicos;
    private List<Obra> obras;

    public Concierto(int idConcierto, LocalDateTime fecha, String sala) throws ConciertoException {
        setIdConcierto(idConcierto);
        setFecha(fecha);
        setSala(sala);
        this.musicos = new ArrayList<>();
        this.obras = new ArrayList<>();
    }

    public void setIdConcierto(int idConcierto) throws ConciertoException {
        if (idConcierto <= 0) {
            throw new ConciertoException("El ID del concierto debe ser positivo.");
        }
        this.idConcierto = idConcierto;
    }

    public void setFecha(LocalDateTime fecha) throws ConciertoException {
        if (fecha == null) {
            throw new ConciertoException("La fecha del concierto no puede ser nula.");
        }
        this.fecha = fecha;
    }

    public void setSala(String sala) throws ConciertoException {
        if (sala == null || sala.trim().isEmpty()) {
            throw new ConciertoException("La sala del concierto no puede estar vacía.");
        }
        this.sala = sala;
    }

    public int getIdConcierto() {
        return idConcierto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getSala() {
        return sala;
    }

    public List<Musico> getMusicos() {
        return musicos;
    }

    public List<Obra> getObras() {
        return obras;
    }

    public void addMusico(Musico musico) {
        this.musicos.add(musico);
    }

    public void addObra(Obra obra) {
        this.obras.add(obra);
    }

    @Override
    public String toString() {
        return "Concierto :\n" +
                "\t idConcierto=" + idConcierto +
                ", fecha=" + fecha +
                ", sala='" + sala + '\'' +
                "\n \t musicos=" + musicos +
                "\n \t obras=" + obras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Concierto)) return false;
        Concierto concierto = (Concierto) o;
        return idConcierto == concierto.idConcierto &&
                fecha.equals(concierto.fecha) &&
                sala.equals(concierto.sala) &&
                musicos.equals(concierto.musicos) &&
                obras.equals(concierto.obras);
    }
}

