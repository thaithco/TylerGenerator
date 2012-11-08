package edu.unca.thaithco.TylerGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TylerGeneratorTreePopulator extends BlockPopulator{

	public void populate(World world, Random random, Chunk chunk) {
		
		int x, y, z;
		
		for (x = 0; x < 16; x++){
			for(z = 0; z < 16; z++){
				if (random.nextInt(10) < 4){
					for(y = 96; chunk.getBlock(x, y, z).getType() == Material.AIR; y--){
						chunk.getBlock(x, y, z).setType(Material.LONG_GRASS);
						chunk.getBlock(x, y, z).setData((byte)1);
					}
				}
				for(y = 50; chunk.getBlock(x,y,z).getType() == Material.AIR || chunk.getBlock(x,y,z).getType() == Material.LONG_GRASS; y--){
					chunk.getBlock(x, y, z).setType(Material.STATIONARY_WATER);
				}
			}
		}
		
		if(random.nextInt(10) <= 1){
			TreeType type = (random.nextInt(10) >= 3) ? TreeType.BIG_TREE : TreeType.TREE;
			world.generateTree(chunk.getBlock(8,21,8).getLocation(), TreeType.TREE);
		}
	}
}
