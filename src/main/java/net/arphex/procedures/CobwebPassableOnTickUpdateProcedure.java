package net.arphex.procedures;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Map.Entry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CobwebPassableOnTickUpdateProcedure {
   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10.0, 10.0, 10.0), e -> true).isEmpty() && !world.isClientSide()) {
         BlockPos _bp = BlockPos.containing(x, y, z);
         BlockState _bs = Blocks.COBWEB.defaultBlockState();
         BlockState _bso = world.getBlockState(_bp);
         UnmodifiableIterator var10 = _bso.getValues().entrySet().iterator();

         while (var10.hasNext()) {
            Entry<Property<?>, Comparable<?>> entry = (Entry<Property<?>, Comparable<?>>)var10.next();
            Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            if (_property != null && _bs.getValue(_property) != null) {
               try {
                  _bs = (BlockState)_bs.setValue(_property, entry.getValue());
               } catch (Exception var14) {
               }
            }
         }

         world.setBlock(_bp, _bs, 3);
      }
   }
}
