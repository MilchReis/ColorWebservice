package de.nm.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.nm.model.Color;
import de.nm.utils.ColorUtils;

@RestController
@RequestMapping("/color")
public class ColorController {

    @RequestMapping(value = "/rgb/hex/{hex}", method = RequestMethod.GET)
    public Color convert(@PathVariable(value="hex") String hex) {
    	return new Color(hex);
    }

    @RequestMapping(value = "/hex/rgb/{r}/{g}/{b}", method = RequestMethod.GET)
    public Color convert(
    		@PathVariable(value="r") int r,
    		@PathVariable(value="g") int g,
    		@PathVariable(value="b") int b) {
    	return new Color(r, g, b);
    }
    
    @RequestMapping(value = "/hex/name/{name}", method = RequestMethod.GET)
    public Color convertFromName(@PathVariable(value="name") String name) {
    	return new Color(new ColorUtils().getColorHexByName(name));
    }
}
