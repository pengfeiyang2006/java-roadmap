package day12;

/**
 * 设备数据模型 —— 设备维修管理系统的第一个实体类
 * 一台设备包含四个属性：
 * id      唯一标识，对应数据库主键
 * name    设备名称
 * location 所在位置（车间/工位）
 * status  运行状态（正常运行/待维修/维修中/已报废）
 */
public class Device {

    private Long id;
    private String name;
    private String location;
    private String status;

    // 构造方法：创建一台设备时必须提供全部四个属性
    public Device(Long id, String name, String location, String status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
    }

    // getter / setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // 重写 toString：让 System.out.println(device) 能打印出可读信息
    @Override
    public String toString() {
        return "Device{id=" + id
                + ", name='" + name + '\''
                + ", location='" + location + '\''
                + ", status='" + status + '\''
                + '}';
    }
}
