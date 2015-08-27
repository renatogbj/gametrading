package br.com.gt.model.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gt.model.bean.Game;
import br.com.gt.model.enums.Platform;
import br.com.gt.model.service.GameService;

@Component
public final class GameUtil {

	private static final Logger LOG = Logger.getLogger(GameUtil.class);
	
	@Autowired
	private GameService gameService;
	
	@PostConstruct
	public void loadGames() {
		File dir = getGamesDir();
		
		for (File platform : dir.listFiles()) {
			for (File gameImage : platform.listFiles()) {
				
				String gameName = gameImage.getName().substring(0, gameImage.getName().length() - 4);
				Platform gamePlatform = Platform.valueOf(platform.getName());
				
				try {
					byte[] gameImageBytes = Files.readAllBytes(gameImage.toPath());
					
					if (gameService.find(gameName, gamePlatform) == null) {
						gameService.save(new Game(gameName, gamePlatform, gameImageBytes));
					}
				} catch (IOException e) {
					LOG.warn("Couldn't load image from game " + gamePlatform + File.pathSeparator + gameName);
				}
				
			}
		}
	}

	public File getGamesDir() {
		String path = GameUtil.class.getClassLoader().getResource("static/app/images/games").getPath();
		if (StringUtils.isNotBlank(path)) {
			path = path.replaceAll("%20", " ");
			return new File(path);
		}
		return null;
//		return new File("C:\\Users\\Renato Oobj\\Desktop\\Documents\\GitHub\\gametrading\\target\\classes\\static\\app\\images\\games");
	}

	public byte[] extractBytes(File image) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(image);
		WritableRaster raster = bufferedImage.getRaster();
		DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

		return (data.getData());
	}
}
