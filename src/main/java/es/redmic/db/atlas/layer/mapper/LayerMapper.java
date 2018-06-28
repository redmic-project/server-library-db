package es.redmic.db.atlas.layer.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import es.redmic.db.atlas.layer.model.Layer;
import es.redmic.models.es.atlas.LatLonBoundingBox;
import es.redmic.models.es.atlas.dto.LayerDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class LayerMapper extends CustomMapper<Layer, LayerDTO> {
	
	@Value("${property.URL_LAYERS_MEDIASTORAGE}")
	private String URL_LAYERS;
	
	@Override
	public void mapAtoB(Layer a, LayerDTO b, MappingContext context) {
		
		if (a.getLatLonBoundsImage() != null && a.getLatLonBoundsImage().length > 0) {
			b.setLatLonBoundsImage(getLatLonBoundsImageDTO(a.getLatLonBoundsImage()));
			b.setImage(URL_LAYERS + a.getId() + ".png");
		}
	}

	@Override
	public void mapBtoA(LayerDTO b, Layer a, MappingContext context) {
		
		if (b.getLatLonBoundsImage() != null)
			a.setLatLonBoundsImage(getLatLonBoundsImage(b.getLatLonBoundsImage()));
	}
	
	private Double[] getLatLonBoundsImage(LatLonBoundingBox latLonBoundingBoxDTO) {
		
		List<Double> latLonBoundsImage = new ArrayList<Double>();
		latLonBoundsImage.add(latLonBoundingBoxDTO.getMaxX());
		latLonBoundsImage.add(latLonBoundingBoxDTO.getMaxY());
		latLonBoundsImage.add(latLonBoundingBoxDTO.getMinX());
		latLonBoundsImage.add(latLonBoundingBoxDTO.getMinY());
		return latLonBoundsImage.toArray(new Double[latLonBoundsImage.size()]);
	}
	
	private LatLonBoundingBox getLatLonBoundsImageDTO(Double[] latLonBoundingBox) {
		
		if (latLonBoundingBox == null || latLonBoundingBox.length < 4)
			return null;
		
		LatLonBoundingBox latLonBoundsImageDTO = new LatLonBoundingBox();
		latLonBoundsImageDTO.setMaxX(latLonBoundingBox[0]);
		latLonBoundsImageDTO.setMaxY(latLonBoundingBox[1]);
		latLonBoundsImageDTO.setMinX(latLonBoundingBox[2]);
		latLonBoundsImageDTO.setMinY(latLonBoundingBox[3]);
		
		return latLonBoundsImageDTO;
	}
}
