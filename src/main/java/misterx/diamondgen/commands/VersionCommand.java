package misterx.diamondgen.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import misterx.diamondgen.DiamondGen;
import misterx.diamondgen.Util;
import net.minecraft.server.command.ServerCommandSource;

import static com.mojang.brigadier.arguments.LongArgumentType.getLong;
import static com.mojang.brigadier.arguments.LongArgumentType.longArg;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class VersionCommand extends ClientCommand{
    @Override
    public String getName() {
        return "version";
    }

    @Override
    public void build(LiteralArgumentBuilder<ServerCommandSource> builder) {
        builder.then(literal("1.17").executes(context -> setVersion("1.17")))
                .then(literal("1.16").executes(context -> setVersion("1.16")));
    }

    public int setVersion(String ver) {
        if(ver.equals("1.17")) {
            DiamondGen.ver = "1.17";
        }else {
            DiamondGen.ver = "1.16";
        }
        DiamondGen.clear(DiamondGen.gen.currentSeed);
        return 0;
    }
}
