package org.onosproject.net.tunnel;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.Objects;

import org.onosproject.core.DefaultGroupId;
import org.onosproject.net.AbstractModel;
import org.onosproject.net.Annotations;
import org.onosproject.net.NetworkResource;
import org.onosproject.net.provider.ProviderId;

/**
 * The default implementation of an network tunnel. supports for creating a
 * tunnel by connect point ,IP address, MAC address, device and so on.
 */
public final class DefaultTunnel extends AbstractModel implements Tunnel {

    private final TunnelEndPoint src; // a source point of tunnel.
    private final TunnelEndPoint dst; // a destination point of tunnel.
    private final State state;
    private final Type type; // tunnel type
    private final DefaultGroupId groupId; // represent for a group flow table
    // which a tunnel match up
    // tunnel producer
    private final TunnelId tunnelId; // tunnel identify generated by
                                     // ONOS as primary key
    private final TunnelName tunnelName; // name of a tunnel

    /**
     * Creates an active infrastructure tunnel using the supplied information.
     *
     * @param producerName provider identity
     * @param src tunnel source
     * @param dst tunnel destination
     * @param type tunnel type
     * @param groupId groupId
     * @param tunnelId tunnelId
     * @param tunnelName tunnel name
     * @param annotations optional key/value annotations
     */
    public DefaultTunnel(ProviderId producerName, TunnelEndPoint src,
                         TunnelEndPoint dst, Type type, DefaultGroupId groupId,
                         TunnelId tunnelId, TunnelName tunnelName,
                         Annotations... annotations) {
        this(producerName, src, dst, type, Tunnel.State.ACTIVE, groupId,
             tunnelId, tunnelName, annotations);
    }

    /**
     * Creates an tunnel using the supplied information.
     *
     * @param producerName provider identity
     * @param src tunnel source
     * @param dst tunnel destination
     * @param type tunnel type
     * @param state tunnel state
     * @param groupId groupId
     * @param tunnelId tunnelId
     * @param tunnelName tunnel name
     * @param annotations optional key/value annotations
     */
    public DefaultTunnel(ProviderId producerName, TunnelEndPoint src,
                         TunnelEndPoint dst, Type type, State state,
                         DefaultGroupId groupId, TunnelId tunnelId,
                         TunnelName tunnelName, Annotations... annotations) {
        super(producerName, annotations);
        checkNotNull(producerName, "producerName cannot be null");
        checkNotNull(src, "src cannot be null");
        checkNotNull(dst, "dst cannot be null");
        checkNotNull(type, "type cannot be null");
        checkNotNull(state, "state cannot be null");
        this.src = src;
        this.dst = dst;
        this.type = type;
        this.state = state;
        this.groupId = groupId;
        this.tunnelId = tunnelId;
        this.tunnelName = tunnelName;
    }

    @Override
    public TunnelEndPoint src() {
        return src;
    }

    @Override
    public TunnelEndPoint dst() {
        return dst;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public State state() {
        return state;
    }

    @Override
    public NetworkResource resource() {
        return null;
    }

    @Override
    public TunnelId tunnelId() {
        return tunnelId;
    }

    @Override
    public DefaultGroupId groupId() {
        return groupId;
    }

    @Override
    public TunnelName tunnelName() {
        return tunnelName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dst, type, groupId, tunnelId, tunnelName,
                            state);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultTunnel) {
            final DefaultTunnel other = (DefaultTunnel) obj;
            return Objects.equals(this.src, other.src)
                    && Objects.equals(this.dst, other.dst)
                    && Objects.equals(this.type, other.type)
                    && Objects.equals(this.groupId, other.groupId)
                    && Objects.equals(this.tunnelId, other.tunnelId)
                    && Objects.equals(this.tunnelName, other.tunnelName)
                    && Objects.equals(this.state, other.state);
        }
        return false;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("src", src).add("dst", dst)
                .add("type", type).add("state", state).add("groupId", groupId)
                .add("producerTunnelId", tunnelId)
                .add("tunnelName", tunnelName).toString();
    }

}
