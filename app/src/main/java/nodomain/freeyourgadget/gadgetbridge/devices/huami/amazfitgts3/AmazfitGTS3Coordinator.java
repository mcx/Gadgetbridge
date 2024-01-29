/*  Copyright (C) 2022-2024 Daniel Dakhno, José Rebelo, sedy89

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.devices.huami.amazfitgts3;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.zeppos.ZeppOsCoordinator;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.service.DeviceSupport;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.zeppos.AbstractZeppOsFwInstallHandler;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.amazfitgts3.AmazfitGTS3Support;

public class AmazfitGTS3Coordinator extends ZeppOsCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(AmazfitGTS3Coordinator.class);

    @Override
    protected Pattern getSupportedDeviceName() {
        return Pattern.compile(HuamiConst.AMAZFIT_GTS3_NAME + ".*");
    }

    @NonNull
    @Override
    public Class<? extends DeviceSupport> getDeviceSupportClass() {
        return AmazfitGTS3Support.class;
    }

    @Override
    public AbstractZeppOsFwInstallHandler createFwInstallHandler(final Uri uri, final Context context) {
        return new AmazfitGTS3FWInstallHandler(uri, context);
    }

    @Override
    public boolean sendAgpsAsFileTransfer() {
        return false;
    }

    @Override
    public boolean supportsBluetoothPhoneCalls(final GBDevice device) {
        return false;
    }


    @Override
    public int getDeviceNameResource() {
        return R.string.devicetype_amazfit_gts3;
    }


    @Override
    public int getDefaultIconResource() {
        return R.drawable.ic_device_amazfit_bip;
    }

    @Override
    public int getDisabledIconResource() {
        return R.drawable.ic_device_amazfit_bip_disabled;
    }
}
