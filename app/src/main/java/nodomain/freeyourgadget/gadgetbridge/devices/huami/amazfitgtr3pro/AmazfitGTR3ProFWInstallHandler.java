/*  Copyright (C) 2023-2024 José Rebelo

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
package nodomain.freeyourgadget.gadgetbridge.devices.huami.amazfitgtr3pro;

import android.content.Context;
import android.net.Uri;

import java.io.IOException;

import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiFWHelper;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceType;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.zeppos.AbstractZeppOsFwInstallHandler;

class AmazfitGTR3ProFWInstallHandler extends AbstractZeppOsFwInstallHandler {
    AmazfitGTR3ProFWInstallHandler(Uri uri, Context context) {
        super(uri, context);
    }

    @Override
    protected String getFwUpgradeNotice() {
        return mContext.getString(R.string.fw_upgrade_notice_amazfit_gtr3_pro, helper.getHumanFirmwareVersion());
    }

    @Override
    protected HuamiFWHelper createHelper(Uri uri, Context context) throws IOException {
        return new AmazfitGTR3ProFWHelper(uri, context);
    }

    @Override
    protected boolean isSupportedDeviceType(GBDevice device) {
        return device.getType() == DeviceType.AMAZFITGTR3PRO;
    }
}
