package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.EventHandlerClient;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistSkullArmorPiece;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderGenericHead;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderWolfHead;
import its_meow.betteranimalsplus.client.renderer.TESR.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.entity.EntityRendererRegistry;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityReindeerHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.common.tileentity.TileEntityWolfHead;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static final ModelHirschgeistSkullArmorPiece armorModel = new ModelHirschgeistSkullArmorPiece(0.0625F);
	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(new EventHandlerClient());
		EntityRendererRegistry.registerEntityRenderers();
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWolfHead.class, new RenderWolfHead());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityReindeerHead.class, new RenderGenericHead());
	}
    
	public static ModelBiped getArmorModel(){
		return armorModel;
	}
	
}
