package dev.blackhig.zhebushigudu.lover.util;

import net.minecraft.util.math.Vec3d;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.Minecraft;

public class Location
{
    protected static final Minecraft mc;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;
    private double oldY;
    public static boolean moving;
    private boolean ground;
    
    public Location(final double x, final double y, final double z, final float yaw, final float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public static boolean isMoving() {
        return Location.moving;
    }
    
    public Location(final double x, final double y, final double z, final boolean ground, final boolean moving) {
        this.x = x;
        this.y = y;
        this.oldY = y;
        this.z = z;
        this.ground = ground;
        Location.moving = moving;
    }
    
    public boolean isOnGround() {
        return this.ground;
    }
    
    public Location(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0.0f;
        this.ground = true;
        this.pitch = 0.0f;
    }
    
    public Location(final BlockPos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }
    
    public Location(final EntityLivingBase entity) {
        this.x = entity.posX;
        this.y = entity.posY;
        this.z = entity.posZ;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }
    
    public Location(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }
    
    public Location add(final int x, final int y, final int z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
    
    public Location add(final double x, final double y, final double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
    
    public Location subtract(final int x, final int y, final int z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }
    
    public Location subtract(final double x, final double y, final double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }
    
    public Block getBlock() {
        return Location.mc.world.getBlockState(this.toBlockPos()).getBlock();
    }
    
    public double getX() {
        return this.x;
    }
    
    public Location setX(final double x) {
        this.x = x;
        return this;
    }
    
    public double getY() {
        return this.y;
    }
    
    public Location setY(final double y) {
        this.y = y;
        return this;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public Location setZ(final double z) {
        this.z = z;
        return this;
    }
    
    public float getYaw() {
        return this.yaw;
    }
    
    public Location setYaw(final float yaw) {
        this.yaw = yaw;
        return this;
    }
    
    public float getPitch() {
        return this.pitch;
    }
    
    public Location setPitch(final float pitch) {
        this.pitch = pitch;
        return this;
    }
    
    public static Location fromBlockPos(final BlockPos blockPos) {
        return new Location(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }
    
    public BlockPos toBlockPos() {
        return new BlockPos(this.getX(), this.getY(), this.getZ());
    }
    
    public double distanceTo(final Location loc) {
        final double dx = loc.x - this.x;
        final double dz = loc.z - this.z;
        final double dy = loc.y - this.y;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    
    public double distanceToXZ(final Location loc) {
        final double dx = loc.x - this.x;
        final double dz = loc.z - this.z;
        return Math.sqrt(dx * dx + dz * dz);
    }
    
    public double distanceToY(final Location loc) {
        final double dy = loc.y - this.y;
        return Math.sqrt(dy * dy);
    }
    
    public Vec3d toVector() {
        return new Vec3d(this.x, this.y, this.z);
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
