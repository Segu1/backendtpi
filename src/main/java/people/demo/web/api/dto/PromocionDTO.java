package people.demo.web.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import people.demo.domain.Promocion;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PromocionDTO {
    @NotBlank(message = "La promocion debe tener un id no nulo")
    private int PromocionId;
    private int nroTelefono;
    private String marca;
    private double porc;
    private LocalDateTime fechaFin;

    public PromocionDTO(Promocion entity){
        PromocionId = entity.getPromocionId();
        marca = entity.getMarca();
        porc = entity.getPorc();
        fechaFin = entity.getFechaHasta();
    }
    public Promocion toEntity(PromocionDTO promocionDTO) {
        if (promocionDTO == null) return null;
        Promocion promocion = new Promocion();
        promocion.setPromocionId(promocionDTO.PromocionId);
        promocion.setPorc(promocionDTO.porc);
        promocion.setMarca(promocionDTO.marca);

        return promocion;
    }

}
