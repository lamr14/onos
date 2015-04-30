/*
 * Copyright 2015 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.net.tunnel;

import static com.google.common.base.Preconditions.checkNotNull;
import org.onosproject.core.DefaultGroupId;
import org.onosproject.net.AbstractDescription;
import org.onosproject.net.SparseAnnotations;
import org.onosproject.net.provider.ProviderId;

import com.google.common.base.MoreObjects;

/**
 * Default implementation of immutable tunnel description entity.
 */
public class DefaultTunnelDescription extends AbstractDescription
        implements TunnelDescription {

    private final TunnelId tunnelId;
    private final TunnelEndPoint src;
    private final TunnelEndPoint dst;
    private final Tunnel.Type type;
    private final DefaultGroupId groupId; // represent for a group flow table
    // which a tunnel match up
    // tunnel producer
    private final ProviderId producerName; // tunnel producer name
    private final TunnelName tunnelName; // name of a tunnel

    /**
     * Creates a tunnel description using the supplied information.
     *
     * @param id TunnelId
     * @param src TunnelPoint source
     * @param dst TunnelPoint destination
     * @param type tunnel type
     * @param groupId groupId
     * @param producerName tunnel producer
     * @param tunnelName tunnel name
     * @param annotations optional key/value annotations
     */
    public DefaultTunnelDescription(TunnelId id, TunnelEndPoint src,
                                    TunnelEndPoint dst, Tunnel.Type type,
                                    DefaultGroupId groupId,
                                    ProviderId producerName,
                                    TunnelName tunnelName,
                                    SparseAnnotations... annotations) {
        super(annotations);
        checkNotNull(producerName, "producerName cannot be null");
        checkNotNull(src, "src cannot be null");
        checkNotNull(dst, "dst cannot be null");
        checkNotNull(type, "type cannot be null");
        this.tunnelId = id;
        this.src = src;
        this.dst = dst;
        this.type = type;
        this.groupId = groupId;
        this.producerName = producerName;
        this.tunnelName = tunnelName;
    }

    @Override
    public TunnelId id() {
        return tunnelId;
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
    public Tunnel.Type type() {
        return type;
    }

    @Override
    public DefaultGroupId groupId() {
        return groupId;
    }

    @Override
    public ProviderId producerName() {
        return producerName;
    }

    @Override
    public TunnelName tunnelName() {
        return tunnelName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tunnelId", id())
                .add("src", src())
                .add("dst", dst())
                .add("type", type())
                .add("tunnelName", tunnelName())
                .add("producerName", producerName())
                .add("groupId", groupId())
                .toString();
    }

}
