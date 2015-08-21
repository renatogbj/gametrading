package br.com.gt.model.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gt.model.bean.Game;
import br.com.gt.model.service.GameService;

@Component
public final class GameUtil {

	@Autowired
	private GameService gameService;
	
	public void loadGamesFromDir() throws IOException {
		File dir = getGamesDir();
		for (File platform : dir.listFiles()) {
			for (File gameImage : platform.listFiles()) {
				Game game = new Game();
				game.setName(gameImage.getName().substring(0, gameImage.getName().length() - 4));
				game.setPlatform(platform.getName());
				game.setCover(Files.readAllBytes(gameImage.toPath()));
				
				gameService.save(game);
			}
		}
	}

	public File getGamesDir() {
		return new File(GameUtil.class.getClassLoader().getResource("static/app/images/games").getPath());
	}

	public byte[] extractBytes(File image) throws IOException {
		// open image
		BufferedImage bufferedImage = ImageIO.read(image);

		// get DataBufferBytes from Raster
		WritableRaster raster = bufferedImage.getRaster();
		DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

		return (data.getData());
	}
}
